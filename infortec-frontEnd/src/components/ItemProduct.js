import { useEffect, useState } from "react";
import "../styles/ItemProduct.css"
import { BsHeart } from "react-icons/bs";
import ShoppingCartService from "../services/ShoppingCartService"

const ItemProduct = (props)=>{
    async function handleAddItemCart(nameProduct, idClient, quantityProduct){
        const data = {nameProduct, idClient, quantityProduct}

        await ShoppingCartService.addItemCart(data)
    }

    const [idClient, setClient] = useState("")
    useEffect(()=>{
        setClient(localStorage.getItem("userId"))
    }, [])
    
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
                <button onClick={()=> handleAddItemCart(props.name, idClient, 1)}> Comprar</button>
            </div>
        </div>
    )
}

export default ItemProduct