import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from 'react-router-dom'


const AllAnime = () => {

    const [animeList, setAnimeList] = useState([]);
    const axios = require("axios");
    const encodedParams = new URLSearchParams();
    encodedParams.append("accessToken", "<REQUIRED>");
    encodedParams.append("userId", "<REQUIRED>");

    const options = {
        method: "POST",
        url: "https://anilistmikilior1v1.p.rapidapi.com/getAnimeList",
        header: {
            "content-type": "application/x-www-form-urlencoded",
            "X-RapidAPI-Host": "Anilistmikilior1V1.p.rapidapi.com",
            "X-RapidAPI-Key": "8e00e00e31msh0378357908dc340p11db1ejsnda17ed8e232a"
        },
        data: encodedParams
    }


    useEffect(() => {
        axios.request(options).then((response) => {
                setAnimeList(response.data.results)
            })
            .catch((err) => {
                console.error(err)
            })
    }, [])


    return (
        <>
            <div className="nav-bar d-flex">
                <div className="nav-links d-flex">
                    <h2><span style="color: blue">Website </span></h2>
                    <p><strong>Home</strong></p>
                    <p>Series</p>
                    <p>Manga</p>
                    <p>My List</p>
                </div>
                <div className="search-bar">
                    <img src="" alt="" />
                    {/* insert magnifine glass here */}
                    <input type="text" placeholder="Titles"/>
                    <Link>Login | Sign Up</Link>
                </div>
            </div>
            {
                animeList.map((animeItem) => {
                    return(
                        <div key = { animeItem } className="">
                            <div className="my-list">
                                
                            </div>
                            <div className="genres">
                                
                            </div>
                        </div>
                    )
                })
            }
        </>
    )
}

export default AllAnime;


