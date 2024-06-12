/*アコーディオン（閉開式）メニュー
*index.htmlのh2要素に以下のclass属性を追加します。
*
*------classの追加------
*<h2 class="accordionHead"></h3>
*<ul>
*	<li>...</li>
*	<li>...</li>
*</ul>
*----------------------
*
*index.htmlのbody要素の終了タグ直前に
*<script src="Accordion.js"><\script>
*を追加し,本JavaScriptファイルを読み込みます。
*
*ブラウザ上でh3要素をクリックした際に、直後のul要素が非表示・表示と切り替わります。
*
*/

(function(){
	var accordionHead = document.getElementsByClassName("accordionHead");
	var switchContent;
	for(i=0;i<accordionHead.length;i++){
		accordionHead[i].onclick = function(){
			switchContent = this.nextElementSibling;
			if(switchContent.style.display == "none"){
				switchContent.style.display  = "block";
			}else{
				switchContent.style.display  = "none";
			}
		};
	}
})();