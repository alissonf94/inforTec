import { useEffect, useState } from "react";
import "../styles/ItemProduct.css"
import { BsHeartFill } from "react-icons/bs";
import { BsHeart } from "react-icons/bs";
import ShoppingCartService from "../services/ShoppingCartService"
import FavoriteService, { verifyProductInFavoritesByClient } from "../services/FavoriteService"

const ItemProduct = (props)=>{
    
    async function handleAddFavorite (idProduct, idClient){
        const data = {idProduct, idClient}
        await FavoriteService.addFavorite(data) 
    }

    async function handleAddItemCart(nameProduct, idClient, quantityProduct){
        const data = {nameProduct, idClient, quantityProduct}
        await ShoppingCartService.addItemCart(data)
    }
   
    
   async function vefifyBookInFavoritesByClient (idClient, idProduct){
    const data = {idClient, idProduct}   
    const response =  await FavoriteService.verifyProductInFavoritesByClient(data)

    const result = await response.json()
    console.log(result);
        if(result === true) {
            return(
                <BsHeartFill onClick={()=> handleAddFavorite(props.id, idClient)} className="favorite" color="#327CAD" size={25}/>
            )
        }
        else{
            return (
                <BsHeart onClick={()=> handleAddFavorite(props.id, idClient)} className="favorite" color="#327CAD" size={25}/>
            )
        }
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
                {vefifyBookInFavoritesByClient()} 
            </div>
            <div className="buy-itemProduct">
                <button onClick={()=>   handleAddItemCart(props.name, idClient, 1)}>Comprar</button>
            </div>
        </div>
    )
}

export default ItemProduct