var main = {
    init: function () {
        const _this = this;
        $('#btn-upload').on('click', function () {
            _this.upload(_this);
        });
    },
    upload: function (_this) {
        const data = {
            fileNm: $('#fileNm').val(),
            fileContent: $('#fileContent').val()
        };

        $.ajax({
            type: 'POST',
            url: '/upload',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (res) {
            if (res == true) {
                alert("업로드 완료 되었습니다.");
                location.href = "/file"
            } else {
                alert("이미 업로드된 파일");
                location.href = "/file"
            }

        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();