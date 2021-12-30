window.onload= ()=>{
	function addTag(){
    		
    		farwindow = window.open("/yakcook/tagadd", "태그 추가", "width=550, height=300, toolbar=no, menubar=no, scrollbars=no, resizable=no");
    		if (farwindow != null) {
    			if (farwindow.opener == null) {
    				farwindow.opener = self;
    			}
    		}
    	};
	var home = document.getElementById("home");
	home.addEventListener('click', () => {
		window.location = "yacook/taglist";
	});
}