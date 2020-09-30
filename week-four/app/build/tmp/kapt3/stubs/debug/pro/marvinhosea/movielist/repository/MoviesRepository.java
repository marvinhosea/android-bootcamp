package pro.marvinhosea.movielist.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u0013J\u0019\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\r0\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u0019\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ)\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u001f\u0010 \u001a\u00020\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lpro/marvinhosea/movielist/repository/MoviesRepository;", "Lorg/koin/core/KoinComponent;", "remoteApi", "Lpro/marvinhosea/movielist/networking/RemoteApi;", "movieDao", "Lpro/marvinhosea/movielist/data/db/dao/MovieDao;", "(Lpro/marvinhosea/movielist/networking/RemoteApi;Lpro/marvinhosea/movielist/data/db/dao/MovieDao;)V", "addMovieToWatchList", "", "movie", "Lpro/marvinhosea/movielist/data/models/Movie;", "(Lpro/marvinhosea/movielist/data/models/Movie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatResponseMovies", "", "moviesResponse", "Lpro/marvinhosea/movielist/data/models/response/Result;", "category", "", "getAllMovies", "Landroidx/lifecycle/LiveData;", "getMovie", "movieId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMoviesByCategory", "getMoviesFromApi", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyMoviesWatchlist", "userName", "inWatchlist", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "storeMovies", "movies", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public class MoviesRepository implements org.koin.core.KoinComponent {
    private final pro.marvinhosea.movielist.networking.RemoteApi remoteApi = null;
    private final pro.marvinhosea.movielist.data.db.dao.MovieDao movieDao = null;
    
    /**
     * Fetch all movies
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<pro.marvinhosea.movielist.data.models.Movie>> getAllMovies() {
        return null;
    }
    
    /**
     * Fetch by categories
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<pro.marvinhosea.movielist.data.models.Movie>> getMoviesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    /**
     * Fetch single movie
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMovie(int movieId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super pro.marvinhosea.movielist.data.models.Movie> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addMovieToWatchList(@org.jetbrains.annotations.NotNull()
    pro.marvinhosea.movielist.data.models.Movie movie, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMyMoviesWatchlist(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, boolean inWatchlist, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<pro.marvinhosea.movielist.data.models.Movie>> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMoviesFromApi(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    private final java.util.List<pro.marvinhosea.movielist.data.models.Movie> formatResponseMovies(java.util.List<pro.marvinhosea.movielist.data.models.response.Result> moviesResponse, java.lang.String category) {
        return null;
    }
    
    public MoviesRepository(@org.jetbrains.annotations.NotNull()
    pro.marvinhosea.movielist.networking.RemoteApi remoteApi, @org.jetbrains.annotations.NotNull()
    pro.marvinhosea.movielist.data.db.dao.MovieDao movieDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.koin.core.Koin getKoin() {
        return null;
    }
}