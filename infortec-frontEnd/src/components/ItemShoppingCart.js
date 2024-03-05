import { useState } from "react";
import { BsChevronRight } from "react-icons/bs";
import { BsChevronLeft } from "react-icons/bs";


const ItemShoppingCart = (props) => {
    const [quantityProduct, setQuantityProduct] = useState(props.quantity)
    
    async function handleUpdateQuantityProduct (newQuantity){
        if(quantityProduct !== 0){
            setQuantityProduct(newQuantity)
        }
    }

    return(
        <div className="itemCart" key={props.id}>
            <div className="image-itemCart">
                <img src={props.urlImage} />
            </div>
            <div className="name-ItemCart">
                <span>{props.nameProduct}</span>
            </div>
            <div>
                <BsChevronLeft onClick={()=> handleUpdateQuantityProduct(quantityProduct - 1)}/>
                <span>{quantityProduct}</span>
                <BsChevronRight onClick={()=> handleUpdateQuantityProduct(quantityProduct + 1)}/>
            </div>
            <div>
                <span>{props.valueItem}</span>
            </div>
        </div>
    )
}

export default ItemShoppingCart