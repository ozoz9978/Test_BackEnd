$(function () {
    // recieve 버튼에 이벤트 설정해서 초기화
    $('#recieve').on('click', init);
    //  전체 선택 체크박스를 체크하면 모두 체크되도록 설정
    $("#checkAll").on('click', function () {
        if ($(this).is(':checked')) {
            $('tbody input[type=checkbox]').prop('checked', true);
        } else {
            $('tbody input[type=checkbox]').prop('checked', false);

        }
    });
    // 삭제버튼을 클릭하면 체크된 모든 고객 명단을 삭제
    $("#deleteMember").on('click', function () {
        let checkItem = $('tbody input[type=checkbox]:checked');
        checkItem.parent().parent().remove(); // tr을 삭제하기 위해 부모의 부모
    });
});

function init() {
    // Clear the tbody before appending new data
    $('tbody').empty();

    // Initialize final as an empty string to store all the rows
    let tag = '';

    // Loop through each item in receivedData
    $.each(recievedData, function (index, item) {
        let name = item['name'];
        let email = item['email'];
        let content = item['content'];

        // Append each row to the final string
        tag +=
            `<tr>
                        <td class="box"><input type="checkbox"></td>
                        <td class="name">${name}</td>
                        <td class="email">${email}</td>
                        <td class="content">${content}</td>
                        <td class="btn"><input type="button" class="btn" value="삭제"></td>
                    </tr>`;
    });

    // Set the final string as the HTML content of the tbody
    $('tbody').html(tag);
    $('.btn').on('click', deleteItem);
}

function input() {
    let name = $('name').val();
    let pwd = $('pwd').val();
    let content = $('#content').val();

    let sendData = { "name": name, "pwd": pwd, "content": content };

    $.ajax({
        url: 'inputGuestbook'
        , method: 'POST'
        , data: sendData
        , success: function () {
            Init();
            clearAll();
        }
    })

}

// 입력상자의 내용 삭제
function clearAll() {
    $('#name').val("");
    $('#pwd').val("");
    $('#content').val("");

}
// 데이터를 삭제하는 함수
function deleteItem(e) {

    let seq = $(this).attr("data-seq");
    let pwd = prompt("비밀번호를 입력하세요");

    let answer = confirm("삭제하시겠습니까?");
    if (!answer) return;

    e.stopPropagation();

    $.ajax({
        url: 'deleteGuestbook'
        , method: 'POST'
        , data: { "seq": seq, "pwd": pwd }
        , success: init

    });
}