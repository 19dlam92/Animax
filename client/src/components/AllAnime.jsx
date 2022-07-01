import React, { useState, useEffect } from "react";
import axios from "axios";
import { Link } from 'react-router-dom'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faChevronRight, faChevronLeft, faEdit } from '@fortawesome/free-solid-svg-icons';


const AllAnime = () => {

    const [animeList, setAnimeList] = useState([]);

    useEffect(() => {
        axios.get("http://localhost:8000/api/animes")
            .then((response) => {
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


