import "../styles/ItemProduct.css"
import { BsHeart } from "react-icons/bs";
const ItemProduct = (props)=>{
   return (
        <div className="itemProduct" key={props.id}>
            
            <div className="images-itemProduct">
                < img src={props.urlImage} className="image-itemProduct"></img>
            </div>

            <div className="name-itemProduct">
                <span className="valeu-itemProduct">{props.name}</span>
            </div>
            <div className="prices-itemProduct">
                <span className="price-itemProduct"> R$ {props.price}</span>
                <span className= "type-pagament">Á vista</span> 
                <BsHeart className="favorite" color="#327CAD" size={25}/>
            </div>
            <div className="buy-itemProduct">
                <button> Comprar</button>
            </div>
        </div>
    )
}

export default ItemProduct