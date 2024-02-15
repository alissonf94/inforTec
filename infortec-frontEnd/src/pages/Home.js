import { useEffect, useState, useRef} from "react"
import NavBar from "../components/NavBar"
import "../styles/Home.css"
import PromotionsService from "../services/PromotionService"
import ItemPromotion from "../components/ItemPromotion"
import { SlArrowRight } from "react-icons/sl";
import { SlArrowLeft } from "react-icons/sl";
const Home = ()=> {

    const [promotions, setPromotions] = useState([])
    const carousel = useRef(null)

    async function getPromotions (){
        const result = await PromotionsService.findAllPromotions()
        
        const data =  await result.json()
        
        setPromotions(data)
    }

    useEffect(() => {
        getPromotions();
    }, []);

    const handleLeftClick = (e) => {
        e.preventDefault();
        carousel.current.scrollLeft -= carousel.current.offsetWidth;
      };
    
      const handleRightClick = (e) => {
        e.preventDefault();
    
        carousel.current.scrollLeft += carousel.current.offsetWidth;
      };

    return (
    <main id="mainHome">
        <NavBar/>
        <div className="promotions">
            <div>
                <h1 className="title">
                    Ofertas da semana
                </h1>
            </div>
            <div className="carousel"  ref={carousel}>
                {promotions.map((item) =>{
                    return(
                        <ItemPromotion urlImage = {item.imgUrl} price = {item.price} pricePromotion = {item.pricePromotion} name={item.nameProduct} id={item.name}/>
                    )
                }
            )
            }
                </div>
                <div className="buttons" >
                        <SlArrowLeft size={40}  onClick={handleLeftClick} color="white" className="button"/>
                        <SlArrowRight onClick={handleRightClick} color ="white"size={40} className="button"/>
                </div>
            </div>
    </main>
    )
}

export default Home