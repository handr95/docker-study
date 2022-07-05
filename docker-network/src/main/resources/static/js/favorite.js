var main = {
    init: function () {
        const _this = this;
        $('#btn-save').on('click', function () {
            _this.save(_this);
        });
    },
    save: function (_this) {
        const data = {
            type: $('#type').val(),
            name: $('#name').val(),
            url: $('#url').val()
        };

        $.ajax({
            type: 'POST',
            url: '/fav/save',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function (res) {
            alert("저장 되었습니다.");

        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();