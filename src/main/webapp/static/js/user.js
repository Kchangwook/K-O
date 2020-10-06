const user = {
    standard: {
        'userId': {
            'name': 'id',
            'minLength': 1,
            'maxLength': 20,
            'tagIdName': 'id',
            'duplicate': false
        },
        'userPassword': {
            'name': '비밀번호',
            'minLength': 1,
            'maxLength': 20,
            'tagIdName': 'password'
        },
        'userNick': {
            'name': '닉네임',
            'minLength': 1,
            'maxLength': 10,
            'tagIdName': 'nick'
        },
        'userEmail': {
            'name': '이메일',
            'minLength': 1,
            'maxLength': 20,
            'tagIdName': 'email'
        },
        'userName': {
            'name': '이름',
            'minLength': 1,
            'maxLength': 10,
            'tagIdName': 'name'
        },
    },
    isValidValue: (value, propertyName) => {
        if(user.isEmptyValue(value, propertyName) || user.isValueLengthExceed(value, propertyName)) {
            $(`#${user.standard[propertyName].tagIdName}`).focus();
            return false;
        }

        if(propertyName === 'userId' && user.standard.userId.duplicate) {
            alert('아이디가 중복되었습니다. 확인해 주세요.');
            $('#id').focus();
            return false;
        }

        if(propertyName === 'userEmail' && validator.isValidEmail(value) === false) {
            alert('유효한 형식의 이메일이 아닙니다.');
            $('#email').focus();
            return false;
        }

        return true;
    },
    isEmptyValue: (value, propertyName) => {
        if(stringUtils.isEmpty(value)) {
            alert(`${user.standard[propertyName].name}는 빈칸이 될 수 없습니다.`);
            return true;
        }

        return false;
    },
    isValueLengthExceed: (value, propertyName) => {
        const property = user.standard[propertyName];
        if(value.length > property.maxLength) {
            alert(`${property.name}는 ${property.minLength}자 이상 ${property.maxLength}자 이하입니다.`);
            return true;
        }

        return false;
    },
    checkIdDuplicated: () => {
        const userId = $('#id').val();

        $.ajax({
            url: `/user/check/${userId}`,
            type: 'GET',
            success: (result) => {
                if(result) {
                    $('#duplicate-id').removeClass('hidden');
                    user.standard.userId.duplicate = true;
                } else {
                    $('#duplicate-id').addClass('hidden');
                    user.standard.userId.duplicate = false;
                }
            },
            error: () => {
                alert('서버에 오류가 발생해 ID 중복 체크를 할 수 없습니다.');
                location.reload();
            }
        });
    },
    getData: () => {
        return {
            'userId': $('#id').val(),
            'userPassword': $('#password').val(),
            'userNick': $('#nick').val(),
            'userEmail': $('#email').val(),
            'userName': $('#name').val(),
            'userType': $('.user-type:checked').val()
        }
    },
    isValidData: (data) => {
        return user.isValidValue(data.userId, 'userId')
            && user.isValidValue(data.userPassword, 'userPassword')
            && user.isValidValue(data.userNick, 'userNick')
            && user.isValidValue(data.userEmail, 'userEmail')
            && user.isValidValue(data.userName, 'userName');
    }
};