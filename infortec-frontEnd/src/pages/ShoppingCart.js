import { useEffect, useState } from "react"
import ShoppingCartService from "../services/ShoppingCartService"
import NavBar from "../components/NavBar"
import ItemShoppingCart from "../components/ItemShoppingCart"
import "../styles/ShoppingCart.css"
import { CiBoxList } from "react-icons/ci";
const ShoppingCart = ()=>{
   const [itensProduct, setItensProduct] = useState([])
   const idClient = localStorage.getItem('userId')
    const [valueBuy, setValueBuy] = useState(0) 
   async function getItemsProducts (){
        try {
            const result  = await ShoppingCartService.getItemsProducts(idClient)

            const data = await result.json()
            setItensProduct(data.itens)
            setValueBuy(data.valueBuy)
        } 
        catch (error) {
            
        }
   }

   useEffect(()=>{
    getItemsProducts()
   }, [itensProduct])

    return(
        <div className="container-shoppingCart">
            <NavBar/>
            <div className="container2-shoppingCart">
                <div className="itens">
                    <div 
                    className="title-itensShoppingCart">
                        <CiBoxList className="icon-title" size={25} color="#327CAD"/>
                        <h2>ITENS DO CARRINHO</h2>
                    </div>
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
                
                <div className="information-valueBuy">
                    <span className="title-information-valueBuy">Resumo</span>
                    <div>
                        <span>Quant. de itens:</span>
                        <span className="quantityItens"></span>
                    </div>
                    <div>
                        <span>Frete:</span>
                        <span className="frete">R$ 0.00</span>
                    </div>
                    <div className="valueBuy">
                        <span >{valueBuy}</span>
                    </div>
                    <div>
                        <button>Finalizar compra</button>
                    </div>
                    <div>
                        <button>Continuar comprando</button>
                    </div>
                </div>   
            </div>
        </div>
    )
}

export default ShoppingCart