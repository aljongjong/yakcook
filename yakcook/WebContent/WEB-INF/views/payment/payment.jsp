<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����������</title>
    <link rel="stylesheet" href="./01_����.css">
    <script src="http://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>

<body>
    <div id="wrap">
        <header>

        </header>

        <section>

            <div id="postdiv">
                <!--������ ����-->

                <div id="order"><label>�ֹ���</label></div>
                <div id="order-info">

                    <label>�̸�</label>
                    <br>
                    <input type="text" name="order" id="order">
                    <br>
                    <label>����ó</label>
                    <br>
                    <input type="text" name="phone1" class="phone" maxlength="3"> -
                    <input type="text" name="phone2" class="phone" maxlength="4"> -
                    <input type="text" name="phone3" class="phone" maxlength="4">
                    <br>
                </div>

                <div id="addressname">
                    <label>�����</label>
                </div>

                <div id="orderaddress">
                    <label>�̸�</label><br>
                    <input type="text" name="" id=""><br>


                    <label>�����ȣ</label><br>
                    <input type="text" id="postcode" placeholder="�����ȣ"><br>
                    <input type="button" onclick="execDaumPostcode()" value="�����ȣ �˻�" id="postbtn"><br>


                    <label>�����</label>
                    <br>
                    <input type="text" id="address" placeholder="�ּ�"><br>


                    ���ּ�
                    <br>
                    <input type="text" id="detailAddress" placeholder="���ּ�">
                </div>

                <div id="delivery_memo">
                    <label>��۸޸�</label>
                    <select name="memo_option" id="memo_option">
                        <option value="postmemo1">��� �� ��û������ �������ּ���</option>
                        <option value="postmemo2">���� �� ���ǿ� �ð��ּ���</option>
                        <option value="postmemo3">���� �� �� �տ� ���ּ���</option>
                        <option value="postmemo4">��� �� ���� �ٶ��ϴ�</option>
                        <option value="postmemo5">�ļ��� ������ �ִ� ��ǰ�Դϴ� ��۽� �������ּ���</option>
                        <option value="postmemo6">�����Է�</option>
                    </select>
                    <br>
                    <textarea name="selbox" id="selbox" cols="60" rows="5" maxlength="50" placeholder="�ִ� 50���� �����մϴ�."></textarea>
                    <br>
                    <span id="�߰���ۺ�">���� �� �갣 ������ ����� �߰� ��ۺ� �߻��� �� �ֽ��ϴ�. </span>
                </div>



            </div>

            <div id="info-list">
                <!--��������-->
                <div>
                    <span id="sum">��ǰ �հ�</span>
                    <span id="pro.val">155000</span>
                </div>

                <div>
                    <span id="delivery">��ۺ�</span>
                    <span id="delivery.val">3000</span>
                </div>

                <div>
                    <span id="sale">�� ���� �ݾ�</span>
                    <span id="sale.val">0</span>
                </div>

                <div>
                    <span>���� �ݾ�</span>
                    <span>158000</span>
                </div>

            </div>

            
        </section>

        <footer>


        </footer>
    </div>
    <script>
        // īī���ּ� API
        function execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function (data) {
                    // �˾����� �˻���� �׸��� Ŭ�������� ������ �ڵ带 �ۼ��ϴ� �κ�.

                    // �� �ּ��� ���� ��Ģ�� ���� �ּҸ� �����Ѵ�.
                    // �������� ������ ���� ���� ��쿣 ����('')���� �����Ƿ�, �̸� �����Ͽ� �б� �Ѵ�.
                    var addr = ''; // �ּ� ����
                    var extraAddr = ''; // �����׸� ����

                    //����ڰ� ������ �ּ� Ÿ�Կ� ���� �ش� �ּ� ���� �����´�.
                    if (data.userSelectedType === 'R') { // ����ڰ� ���θ� �ּҸ� �������� ���
                        addr = data.roadAddress;
                    } else { // ����ڰ� ���� �ּҸ� �������� ���(J)
                        addr = data.jibunAddress;
                    }

                    // ����ڰ� ������ �ּҰ� ���θ� Ÿ���϶� �����׸��� �����Ѵ�.
                    if (data.userSelectedType === 'R') {
                        // ���������� ���� ��� �߰��Ѵ�. (�������� ����)
                        // �������� ��� ������ ���ڰ� "��/��/��"�� ������.
                        if (data.bname !== '' && /[��|��|��]$/g.test(data.bname)) {
                            extraAddr += data.bname;
                        }
                        // �ǹ����� �ְ�, ���������� ��� �߰��Ѵ�.
                        if (data.buildingName !== '' && data.apartment === 'Y') {
                            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                        }
                        // ǥ���� �����׸��� ���� ���, ��ȣ���� �߰��� ���� ���ڿ��� �����.
                        if (extraAddr !== '') {
                            extraAddr = ' (' + extraAddr + ')';
                        }
                        // ���յ� �����׸��� �ش� �ʵ忡 �ִ´�.
                        document.getElementById("extraAddress").value = extraAddr;

                    } else {
                        document.getElementById("extraAddress").value = '';
                    }

                    // �����ȣ�� �ּ� ������ �ش� �ʵ忡 �ִ´�.
                    document.getElementById('postcode').value = data.zonecode;
                    document.getElementById("address").value = addr;
                    // Ŀ���� ���ּ� �ʵ�� �̵��Ѵ�.
                    document.getElementById("detailAddress").focus();
                }
            }).open();
        };


        $(function () {
            $("#selbox").hide();

            $("#memo_option").change(function () {
                if ($("#memo_option").val() == "postmemo6") {
                    $("#selbox").show();
                } else {
                    $("#selbox").hide();
                }
            })
        });

      


    </script>
</body>

</html>