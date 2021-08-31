<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Create</title>
        <link href="/css/main.css" rel="stylesheet">
        <script>
            function send() {
                let object = {
                    "code": document.getElementById("code_snippet").value,
                    "time": document.getElementById("time_restriction").value,
                    "views": document.getElementById("views_restriction").value
                };

                let json = JSON.stringify(object);

                let xhr = new XMLHttpRequest();
                xhr.open("POST", '/api/code/new', false)
                xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
                xhr.send(json);

                if (xhr.status == 200) {
                    alert("Success!");
                } else {
                    alert("Error!");
                }
            }
        </script>
    </head>
    <body>
        <textarea id="code_snippet">Paste your code snippet here</textarea>
        <br>
        Time restriction: <input id="time_restriction" type="text" value="0"/>
        <br>
        View restriction: <input id="views_restriction" type="text" value="0"/>
        <br>
        <button id="send_snippet" type="submit" onclick="send()">Submit</button>
    </body>
</html>