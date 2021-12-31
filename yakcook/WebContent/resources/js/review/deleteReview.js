var deleteBtn = document.getElementById('deleteButton');

deleteBtn.onclick = function(){
    if(confirm("삭제하시겠습니까?")){
        alert("삭제하기");
    }else{
        alert("취소하기");
    }
};


