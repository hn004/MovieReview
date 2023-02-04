package github.hn004.MovieApi;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@Autowired
	MovieRepository repo;
	
	@GetMapping("/movie")
	public ResponseEntity<String> movies() {
		return new ResponseEntity<>("movie", HttpStatus.OK);
	}
	
	
	@GetMapping("/allMovies")
	public ResponseEntity<List<Movie>> getAllMovies(){
		return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/getmovie/{id}")
	public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
		Optional<Movie> movie=repo.findById(id);
		return new ResponseEntity<Optional<Movie>>(movie,HttpStatus.OK);
	}
	
	@GetMapping("movieByImdbId/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.findMovieByImdbId(imdbId), HttpStatus.OK);
    }
	

}
