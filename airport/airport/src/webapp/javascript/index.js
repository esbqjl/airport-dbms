function showButton(sub){
var subList = document.getElementsByClassName("sub");
console.log(subList[0].classList[0]);
for(let k=0;k<subList.length;k++){
    let a = subList[k];
    if(a.classList.contains("hide")==false){
        a.classList.add("hide");
        }
    }
    var buttonList = document.getElementsByClassName(sub);
    for(let i=0;i<buttonList.length;i++){
        let b =buttonList[i];
        b.classList.remove("hide");
        }
}
