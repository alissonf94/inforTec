import { useEffect, useState } from "react"
import ShoppingCartService from "../services/ShoppingCartService"
import NavBar from "../components/NavBar"
import ItemShoppingCart from "../components/ItemShoppingCart"
import ItemProduct from "../components/ItemProduct"
const ShoppingCart = ()=>{
   const [itensProduct, setItensProduct] = useState([])
    const idClient = localStorage.getItem('userId')

   async function getItemsProducts (){
    try {
        const result  = await ShoppingCartService.getItemsProducts(idClient)

        const data = await result.json()
        setItensProduct(data.itens)
        console.log(data);
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
            <div className="">
                {itensProduct.map((item)=>{
                    return(
                        <ItemShoppingCart key= {item.id} urlImage = {item.product.imgUrl} nameProduct = {item.product.name}
                        quantity = {item.quantityProduct}
                        valueItem = {item.valueItem}
                        />
                    )
                })}
            </div>
        </div>
    )
}

export default ShoppingCart