package pro.marvinhosea.movielist.ui.movies.show;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lpro/marvinhosea/movielist/ui/movies/show/MovieDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/koin/core/KoinComponent;", "movieRepository", "Lpro/marvinhosea/movielist/repository/MoviesRepository;", "(Lpro/marvinhosea/movielist/repository/MoviesRepository;)V", "addToWatchList", "", "movie", "Lpro/marvinhosea/movielist/data/models/Movie;", "(Lpro/marvinhosea/movielist/data/models/Movie;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMovie", "movieId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MovieDetailViewModel extends androidx.lifecycle.ViewModel implements org.koin.core.KoinComponent {
    private final pro.marvinhosea.movielist.repository.MoviesRepository movieRepository = null;
    
    /**
     * Retrieve movie by movie ID
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMovie(int movieId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super pro.marvinhosea.movielist.data.models.Movie> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addToWatchList(@org.jetbrains.annotations.NotNull()
    pro.marvinhosea.movielist.data.models.Movie movie, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> p1) {
        return null;
    }
    
    public MovieDetailViewModel(@org.jetbrains.annotations.NotNull()
    pro.marvinhosea.movielist.repository.MoviesRepository movieRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public org.koin.core.Koin getKoin() {
        return null;
    }
}