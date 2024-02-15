import { BsCart3 } from "react-icons/bs";
import { BsPersonCircle } from "react-icons/bs";
import { CiLogin } from "react-icons/ci";
import "../styles/NavBar.css"
import { BsHeart } from "react-icons/bs";
import { BsSearch } from "react-icons/bs";
import { useNavigate } from "react-router-dom";

export default function NavBar(){
const navigate = useNavigate()
    return(
        <div id="mainNavBar">
            <section id="sectionSearch">
                <img id="imgLogo" src={require("../imgs/Logo.png")} alt="" onClick={()=> navigate("/home") }></img>
                <div id="searchContainer">
                    <BsSearch id="iconSearch" color="#327CAD" size={20} />
                    <input id="search"></input>
                </div>
                
                <div id="icons">
                    <BsHeart color="#fff"  size={22} />
                    <BsCart3 color="#ffff"  size={22}/>
                    <BsPersonCircle color="#fff"  size={23}/>
                </div>
            </section>
            <section id="sectionTypesProducts">
                <a href="/computers">Computadores</a>
                <a href="/monitors">Monitores</a>
                <a href="/keyboards">Teclados</a>
                <a href="/accessories">Acessórios</a>
            </section>
        </div>
    )
}