$(document).ready(() => {
    setupAjax();
    checkToken();
    hello();
});

let hello = () => {

    let sendData = {
        message : 'Hello World!'
    }
    // /hello
    $.ajax({
        method: 'POST',
        url: '/webs/hello',
        data: JSON.stringify(sendData), // 데이터를 JSON 형식으로 변환
        contentType: 'application/json; charset=utf-8', // 전송 데이터의 타입
        dataType: 'json', // 서버에서 받을 데이터의 타입
        success: (response) => {
            console.log('response :: ', response)
        },
        error: (xhr) => {
            if (xhr.status === 401) {
                // Refresh Token을 통해 Access Token 재발급 요청
                // handleTokenExpiration();
            } else {
                // 다른 오류 처리
                console.error('요청 오류 발생:', xhr);
            }
        }
    })

}