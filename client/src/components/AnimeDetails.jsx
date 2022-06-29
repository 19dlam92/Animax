import React, { useState, useEffect } from "react";
import axios from "axios";
import { useHistory, useParams } from "react-router-dom";

const AnimeDetails = () => {

    const [details, setDetails] = useState({});
    const history = useHistory();
    const { id } = useParams();

    useEffect(() => {
        axios.get(`http://localhost:8000/api/animes/${id}`)
            .then((response) => {
                setDetails(response.data.results);
            })
            .catch((err) => {
                console.error(err);
            })
    }, [])

    

    return(
        <>
        
        </>
    )
}

export default AnimeDetails;
