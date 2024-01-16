import { BsCart3 } from "react-icons/bs";
import { BsPersonCircle } from "react-icons/bs";
import { CiLogin } from "react-icons/ci";
import "../styles/NavBar.css"
import { BsHeart } from "react-icons/bs";
import { BsSearch } from "react-icons/bs";
export default function NavBar(){
    return(
        <div id="mainNavBar">
            <section id="sectionSearch">
                <img id="imgLogo" src={require("../imgs/Logo.png")} alt=""></img>
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
                <a>Computadores</a>
                <a>Monitores</a>
                <a>Games</a>
                <a>Acessórios</a>
            </section>
        </div>
    )
}