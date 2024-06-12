//「検索」ボタンクリック時の処理
function pushButton() {
  //従業員番号テキストボックスを取得
  var empId = document.getElementById("empId");
  if (empId.value == "") {
    alert("従業員番号を入力してください。");
    return false; //サーバ送信を取り消す
  }
  return true;
}
//初期処理
function setUp() {
  //「検索」ボタン取得
  var findBtn = document.getElementById("findBtn");
  //clickイベントハンドラにpushButton関数を登録
  findBtn.onclick = pushButton;
}
//window.loadイベントハンドラにsetUp関数を登録
window.onload = setUp;