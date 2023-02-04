package github.hn004.MovieApi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository movieRepository;
	
	public List<Movie> allMovies(){
		return movieRepository.findAll()		;
	}
	
	
	public Optional<Movie> findMovieByImdbId(String imdbId){
		return movieRepository.findByImdbId(imdbId);
	}

}
