const url = '/gif';

function getResultGif() {
    let code = $("#select").val();
    $.ajax({
        url: url + '/' + code,
        method: 'GET',
        dataType: "json",
        complete: function (data) {
            let content = JSON.parse(data.responseText);
            // console.log(content);

            let img = document.createElement("img");
            img.src = content.data[0].images.original.url;
            img.height = 350;

            let gifName = document.createElement("p");
            gifName.textContent = content.data[0].title;

            let out = document.querySelector("#out");
            out.innerHTML = '';
            out.insertAdjacentElement("afterbegin", img);
            out.insertAdjacentElement("beforeend", gifName);

        }
    })
}

function loadSelect() {
    $.ajax({
        url: url + '/getCodes',
        method: 'GET',
        complete: function (data) {
            let list = JSON.parse(data.responseText);
            let select = document.querySelector("#select");
            select.innerHTML = '';

            for (let i = 0; i < list.length; i++) {
                let option = document.createElement("option");
                option.value = list[i];
                option.text = list[i];
                select.insertAdjacentElement("beforeend", option);
            }
            select.value = "USD"
        }
    })
}