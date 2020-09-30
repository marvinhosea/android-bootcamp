package pro.marvinhosea.movielist.ui.movies;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bJ\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lpro/marvinhosea/movielist/ui/movies/MovieViewModel;", "Landroidx/lifecycle/ViewModel;", "movieRepository", "Lpro/marvinhosea/movielist/repository/MoviesRepository;", "userSharedRepository", "Lpro/marvinhosea/movielist/repository/UserSharedPrefRepository;", "(Lpro/marvinhosea/movielist/repository/MoviesRepository;Lpro/marvinhosea/movielist/repository/UserSharedPrefRepository;)V", "getAllMovies", "Landroidx/lifecycle/LiveData;", "", "Lpro/marvinhosea/movielist/data/models/Movie;", "getMoviesByCategory", "category", "", "logoutUser", "", "context", "Landroid/content/Context;", "myWatchListMovies", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public class MovieViewModel extends androidx.lifecycle.ViewModel {
    private final pro.marvinhosea.movielist.repository.MoviesRepository movieRepository = null;
    private pro.marvinhosea.movielist.repository.UserSharedPrefRepository userSharedRepository;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<pro.marvinhosea.movielist.data.models.Movie>> getAllMovies() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<pro.marvinhosea.movielist.data.models.Movie>> getMoviesByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object myWatchListMovies(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<pro.marvinhosea.movielist.data.models.Movie>> p0) {
        return null;
    }
    
    public final void logoutUser(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public MovieViewModel(@org.jetbrains.annotations.NotNull()
    pro.marvinhosea.movielist.repository.MoviesRepository movieRepository, @org.jetbrains.annotations.NotNull()
    pro.marvinhosea.movielist.repository.UserSharedPrefRepository userSharedRepository) {
        super();
    }
}