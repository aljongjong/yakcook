import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

	@@ -43,7 +46,8 @@ public String confirmPayment(
            Model model) throws Exception {

        HttpHeaders headers = new HttpHeaders();
        // headers.setBasicAuth(SECRET_KEY, ""); // spring framework 5.2 이상 버전에서 지원
        headers.set("Authorization", "Basic " + Base64.getEncoder().encodeToString((SECRET_KEY + ":").getBytes()));
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> payloadMap = new HashMap<>();
	@@ -58,6 +62,7 @@ public String confirmPayment(
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            JsonNode successNode = responseEntity.getBody();
            model.addAttribute("orderId", successNode.get("orderId").asText());
            String secret = successNode.get("secret").asText(); // 가상계좌의 경우 입금 callback 검증을 위해서 secret을 저장하기를 권장함
            return "success";
        } else {
            JsonNode failNode = responseEntity.getBody();
	@@ -73,4 +78,44 @@ public String failPayment(@RequestParam String message, @RequestParam String cod
        model.addAttribute("code", code);
        return "fail";
    }

    @RequestMapping("/virtual-account/callback")
    @ResponseStatus(HttpStatus.OK)
    public void handleVirtualAccountCallback(@RequestBody CallbackPayload payload) {
        if (payload.getStatus().equals("DONE")) {
            // handle deposit result
        }
    }

    private static class CallbackPayload {
        public CallbackPayload() {}

        private String secret;
        private String status;
        private String orderId;

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }
    }
}