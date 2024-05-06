import { useState } from "react";
import { BsChevronRight } from "react-icons/bs";
import { BsChevronLeft } from "react-icons/bs";
import ItemProductService from "../services/ItemProductService"
import "../styles/ItemCart.css"
import { MdDeleteOutline } from "react-icons/md";

const ItemShoppingCart = (props) => {
    const [quantityProduct, setQuantityProduct] = useState(props.quantity)
    
    async function handleDeleteItemProduct (id){
        await ItemProductService.deleteItemProduct(id)
    }

    async function handleUpdateQuantityProduct (idProduct, newQuantityProduct){
        if(newQuantityProduct > 0){
            setQuantityProduct(newQuantityProduct)
        }
       
        else if(newQuantityProduct <= 0){
            setQuantityProduct(1)
            newQuantityProduct = 1
        }
        const data = {idProduct, newQuantityProduct}
        await ItemProductService.updateItemProduct(data)
    }

    const price = props.valueItem.toFixed(2);
    
    return(
        <div className="itemCart" key={props.id}>
    
            <div className="information-itemCart"> 
                <div className="image-itemCart">
                    <img src={props.urlImage} alt="  product" />
                </div>

                <div className="description-itemCart">
                    <div className="brand-itemCart">
                        <span>{props.productBrand}</span>
                    </div>
                    <div className="name-ItemCart">
                        <span>{props.nameProduct}</span>
                    </div>
                    <div className="price-itemCart">
                        <span>R$ {props.price}</span>
                    </div>
                </div>
            </div>
            
            <div className="functions">
                <div className="spanQuantity">
                    <span>Quant.</span>
                </div>
                <div className="updateQuantity">
                    <BsChevronLeft className="icon" size={20} color="#7f858d" onClick={()=> handleUpdateQuantityProduct(props.id, quantityProduct - 1)}/>
                    <span>{quantityProduct}</span>
                    <BsChevronRight className="icon" size={20} color="#7f858d" onClick={()=> handleUpdateQuantityProduct(props.id, quantityProduct + 1)}/>
                </div>
                <div>
                    <  MdDeleteOutline onClick={()=> handleDeleteItemProduct(props.id)} size={25} color="#7f858d"/>
                </div>
            </div>

            <div className="value-itemCart">
                <span>R$ {price}</span>
            </div>
        </div>
    )
}

export default ItemShoppingCart