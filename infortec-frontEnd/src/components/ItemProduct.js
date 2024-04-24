import "../styles/ItemProduct.css"
import { BsHeartFill } from "react-icons/bs";
import { BsHeart } from "react-icons/bs";
import ShoppingCartService from "../services/ShoppingCartService"
import FavoriteService from "../services/FavoriteService"
import { useState, useEffect} from "react";
const ItemProduct = (props)=>{
    const idClient =  localStorage.getItem("userId");
    const [isFavorite, setIsFavorite] = useState("");

    async function handleAddFavorite (idProduct, idClient){
        const data = {idProduct, idClient}
        await FavoriteService.addFavorite(data) 
    }

    async function handleAddItemCart(nameProduct, idClient, quantityProduct){
        const data = {nameProduct, idClient, quantityProduct}
        await ShoppingCartService.addItemCart(data)
    }
   
    async function handleDeleteProductInFavorites (idProduct){
        await FavoriteService.deleteProductInFavorites(idProduct)
    }
    
   async function vefifyFavoriteInFavorites (idClient, idProduct){
    const data = {idClient, idProduct}   

    const response =  await FavoriteService.verifyProductInFavoritesByClient(data)
   
    const result = await response.json()
    if(result === true){
        setIsFavorite(true)
    }
    else{
         setIsFavorite(false)
    }
    }
    
    vefifyFavoriteInFavorites(idClient, props.id);
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
                {isFavorite ? (<BsHeartFill onClick={()=> handleDeleteProductInFavorites(props.id, idClient)} className="favorite" color="#327CAD" size={25}/>):( (
                <BsHeart onClick={()=> handleAddFavorite(props.id, idClient)} className="favorite" color="#327CAD" size={25}/>
            ))}
            </div>
            <div className="buy-itemProduct">
                <button onClick={()=>   handleAddItemCart(props.name, idClient, 1)}>Comprar</button>
            </div>
        </div>
    )
}

export default ItemProduct