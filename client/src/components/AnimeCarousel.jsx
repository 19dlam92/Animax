import React, { useState } from "react";
import axios from "axios";

const AnimeCarousel = (props) => {

    const [title, setTitle] = useState("");
    const [genre, setGenre] = useState("");
    const [description, setDescription] = useState("");
    const [carouselErrors, setCarouselErrors] = useState({});

    const carouselHandler = (e) => {
        e.preventDefault();
        // keeps the page from re-rendering
        const carouselErrors = { title, genre, description };

        axios.post("http://localhost:8000/api/animes", carouselErrors)
            .then((response) => {
                if (response.data.console.error) {
                    setCarouselErrors(responsedata.console.error.err)
                } else {
                    
                    setTitle("");
                    setGenre("");
                    setDescription("");
                    setCarouselErrors("");
                }
            })
    }


    return(
        <>
        
        </>
    )
}
