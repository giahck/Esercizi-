export interface Root {
    users: User[]
    favorites: Favorite[]
    genres: Genre[]
    "movies-popular": MoviesPopular[]
    "movies-toprated": MoviesToprated[]
  }
  export interface AuthData {
    accessToken: string,
    user: {
        name: string,
        id: string,
        email: string
    }
    }
  export interface User {
    email: string
    password: string
    name: string
    id: number
  }
  
  export interface Favorite {
    userId: number
    movieId: number
    id: number
  }
  
  export interface Genre {
    id: number
    name: string
  }
  
  export interface MoviesPopular {
    adult: boolean
    backdrop_path: string
    genre_ids: number[]
    id: number
    original_language: string
    original_title: string
    overview: string
    popularity: number
    poster_path: string
    release_date: string
    title: string
    video: boolean
    vote_average: number
    vote_count: number
  }
  
  export interface MoviesToprated {
    adult: boolean
    backdrop_path: string
    genre_ids: number[]
    id: number
    original_language: string
    original_title: string
    overview: string
    popularity: number
    poster_path: string
    release_date: string
    title: string
    video: boolean
    vote_average: number
    vote_count: number
  }