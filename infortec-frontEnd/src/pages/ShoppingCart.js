import { useEffect, useState } from "react"
import ShoppingCartService from "../services/ShoppingCartService"
import NavBar from "../components/NavBar"
import ItemShoppingCart from "../components/ItemShoppingCart"
import "../styles/ShoppingCart.css"
import { CiBoxList } from "react-icons/ci";
import { IoIosDocument } from "react-icons/io";

const ShoppingCart = ()=>{
   const [itensProduct, setItensProduct] = useState([])
   const idClient = localStorage.getItem('userId')
   const [valueBuy, setValueBuy] = useState(0) 
   
   async function getItemsProducts (){
        try {
            const result  = await ShoppingCartService.getItemsProducts(idClient)
            const data = await result.json()
            setItensProduct(data.itens)
            const value = parseFloat(data.valueBuy).toFixed(2)
            setValueBuy(value)
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
                    <div className="title-information-valueBuy">
                        <IoIosDocument className="icon-title" size={20} color="#327CAD"/>
                        <span className="t">Resumo</span>
                    </div>
                    
                    <div className="quantityItens-information-valueBuy">
                        <span>Quant. de itens: </span>
                        <span className="value-quantityItens"> {itensProduct.length} </span>
                    </div>
                    <div className="frete-informatio-valueBuy" >
                        <span >Frete:</span>
                        <span className="value-frete">R$ 0.00</span>
                    </div>
                    <div className="valueBuy">
                        <span > R$ {valueBuy}</span>
                    </div>
                    <div className="buttons-information-valueBuy">
                        <button>FINALIZAR A COMPRA</button>
                        <button>CONTINUAR COMPRANDO</button>
                    </div>
                </div>   
            </div>
        </div>
    )
}

export default ShoppingCart