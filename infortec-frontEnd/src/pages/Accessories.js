import { useEffect, useState } from "react"
import NavBar from "../components/NavBar"
import ProductService from "../services/ProductService"
import ItemProduct from "../components/ItemProduct"
import "../styles/Product.css"

const Accessories = ()=>{
    const [products, setProduct] = useState([]) 
    
    async function getProducts () {
        const result = await ProductService.findByCategory("Acessórios");
        
        const data = await result.json()
        setProduct(data)
    }

    useEffect(() => {
        getProducts()
    }, [products])
    
    return (
        <div id="mainProduct">
                <NavBar/>
                <div id="products">
                    {products.map((item) =>{
                        return (
                            <ItemProduct key= {item.id} urlImage = {item.imgUrl} price = {Number(item.price.toFixed(2))} name={item.name} id={item.id}/>
                    )
                })}
                </div>
        </div>
    )
}

export default Accessories