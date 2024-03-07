import { useEffect, useState } from "react"
import ShoppingCartService from "../services/ShoppingCartService"
import NavBar from "../components/NavBar"
import ItemShoppingCart from "../components/ItemShoppingCart"
import "../styles/ShoppingCart.css"
const ShoppingCart = ()=>{
   const [itensProduct, setItensProduct] = useState([])
   const idClient = localStorage.getItem('userId')

   async function getItemsProducts (){
        try {
            const result  = await ShoppingCartService.getItemsProducts(idClient)

            const data = await result.json()
            setItensProduct(data.itens)
        } 
        catch (error) {
            
        }
   }

   useEffect(()=>{
    getItemsProducts()
   }, [])

    return(
        <div>
            <NavBar/>
            <div className="itens">
                {itensProduct.map((item)=>{
                    return(
                        <ItemShoppingCart id= {item.id} urlImage = {item.product.imgUrl} nameProduct = {item.product.name}
                        quantity = {item.quantityProduct}
                        valueItem = {item.valueItem} price = {item.product.price}
                        productBrand = {item.product.brand}
                        />
                    )
                })}
            </div>
        </div>
    )
}

export default ShoppingCart