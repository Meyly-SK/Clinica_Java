const btn_ingresar =  
document.querySelector(".btn_ingresar");
const ingresar = 
document.querySelector("#Cerrar");
const modal = 
document.querySelector("#pop");

btn_ingresar.addEventListener("click",()=>{
 modal.showModal();

})

ingresar.addEventListener("click",()=>{ 
 modal.close();

})

const toggle = document.querySelector(".toggle")
const menuDashboard = document.querySelector(".menu-dashboard")
const iconoMenu = toggle.querySelector("i")
const enlacesMenu = document.querySelectorAll(".enlace")

toggle.addEventListener("click", () => {
    menuDashboard.classList.toggle("open")

    if(iconoMenu.classList.contains("bx-menu")){
        iconoMenu.classList.replace("bx-menu", "bx-x")
    }else {
        iconoMenu.classList.replace("bx-x", "bx-menu")
    }
})

enlacesMenu.forEach(enlace => {
    enlace.addEventListener("click", () => {
        menuDashboard.classList.add("open")
        iconoMenu.classList.replace("bx-menu", "bx-x")
    })
})

function obtenerFecha(e)
{

  var fecha = moment(e.value);
  console.log("Fecha original:" + e.value);
  console.log("Fecha formateada es: " + fecha.format("YYYY/MM/DD"));
}