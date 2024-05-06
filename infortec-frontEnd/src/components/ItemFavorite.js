import { MdDeleteOutline } from "react-icons/md";
import { MdAddShoppingCart } from "react-icons/md";
import "../styles/ItemFavorite.css"
import ShoppingCartService from "../services/ShoppingCartService"
import FavoriteService from "../services/FavoriteService"
import "../styles/ItemFavorite.css"
const itemFavorites = (props) => {
    const idClient = localStorage.getItem("userId")

    async function handleDeleteById(idFavorite){
        await FavoriteService.deleteById(idFavorite)
    }

    async function handleAddItemCart(nameProduct, idClient, quantityProduct){
        const data = {nameProduct, idClient, quantityProduct}
        await ShoppingCartService.addItemCart(data)
    }

    return(
        <div className="itemFavorite" >
            <div className="image-itemfavorite">
                <img src={props.urlImage} alt="" />
            </div>
            <div
            className="description-itemfavorites">
                <div className="brand-itemfavorites">
                        <span>{props.productBrand}</span>
                    </div>
                    <div className="name-itemfavorites">
                        <span>{props.nameProduct}</span>
                    </div>
                    <div className="price-itemFavorites">
                        <span>R$ {props.price}</span>
                    </div>
            </div>
            <div className="function-itemfavorites">
                <MdAddShoppingCart className= "button-delete"color="#7f858d" size={35}/>
                <MdDeleteOutline onClick={()=> handleDeleteById(props.id)} className="button-addCart" color="#7f858d" size={35} />
            </div>
        </div>
    )
}

export default itemFavorites