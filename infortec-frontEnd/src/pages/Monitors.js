import { useEffect, useState } from "react"
import NavBar from "../components/NavBar"
import ProductService from "../services/ProductService"
import ItemProduct from "../components/ItemProduct"
import "../styles/Product.css"

const Monitors = ()=>{
    const [products, setProduct] = useState([])

    async function getProducts () {
        const result = await ProductService.findByCategory("Monitores");
        
        const data = await result.json()

        setProduct(data)
    }

    useEffect(() => {
        getProducts()
    }, [])
    return (
        <div id="mainProduct">
            <NavBar/>
                <div id="products">
                    {products.map((item) =>{
                        return (
                            <ItemProduct urlImage = {item.imgUrl} price = {item.price} name={item.name} id={item.id}/>
                    )
                })}
                </div> 
        </div>
    )
}

export default Monitors