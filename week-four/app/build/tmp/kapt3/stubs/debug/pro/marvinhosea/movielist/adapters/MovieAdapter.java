package pro.marvinhosea.movielist.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u0014\u0010\u0013\u001a\u00020\f2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lpro/marvinhosea/movielist/adapters/MovieAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lpro/marvinhosea/movielist/adapters/MovieAdapter$ViewHolder;", "movies", "", "Lpro/marvinhosea/movielist/data/models/Movie;", "clickListener", "Lpro/marvinhosea/movielist/adapters/MovieAdapter$MovieListClickListener;", "(Ljava/util/List;Lpro/marvinhosea/movielist/adapters/MovieAdapter$MovieListClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "data", "", "MovieListClickListener", "ViewHolder", "app_debug"})
public final class MovieAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<pro.marvinhosea.movielist.adapters.MovieAdapter.ViewHolder> {
    private final java.util.List<pro.marvinhosea.movielist.data.models.Movie> movies = null;
    private final pro.marvinhosea.movielist.adapters.MovieAdapter.MovieListClickListener clickListener = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public pro.marvinhosea.movielist.adapters.MovieAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    pro.marvinhosea.movielist.adapters.MovieAdapter.ViewHolder holder, int position) {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.List<pro.marvinhosea.movielist.data.models.Movie> data) {
    }
    
    public MovieAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<pro.marvinhosea.movielist.data.models.Movie> movies, @org.jetbrains.annotations.NotNull()
    pro.marvinhosea.movielist.adapters.MovieAdapter.MovieListClickListener clickListener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lpro/marvinhosea/movielist/adapters/MovieAdapter$MovieListClickListener;", "", "movieClicked", "", "movie", "Lpro/marvinhosea/movielist/data/models/Movie;", "app_debug"})
    public static abstract interface MovieListClickListener {
        
        public abstract void movieClicked(@org.jetbrains.annotations.NotNull()
        pro.marvinhosea.movielist.data.models.Movie movie);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lpro/marvinhosea/movielist/adapters/MovieAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "movieView", "Landroid/view/View;", "(Landroid/view/View;)V", "movieName", "Landroid/widget/TextView;", "getMovieName", "()Landroid/widget/TextView;", "moviePosterImageView", "Landroid/widget/ImageView;", "getMoviePosterImageView", "()Landroid/widget/ImageView;", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView moviePosterImageView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView movieName = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getMoviePosterImageView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getMovieName() {
            return null;
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View movieView) {
            super(null);
        }
    }
}