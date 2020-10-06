const header = {
    loadHeader: () => {
        $.ajax({
            url: '/check',
            type: 'GET',
            success: (result) => {
                if(result !== null && result !== "") {
                    $('#header').load('/html/common/header.html');
                    $('#header-section').addClass('hidden');
                }
            },
            error: () => {
                alert('서버에 문제가 발생했습니다. 잠시 후 다시 로그인을 시도해주세요.');
            }
        });
    }
};