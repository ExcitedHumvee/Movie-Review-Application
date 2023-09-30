import com.stanydesa.movie.MovieApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = MovieApplication.class)
@AutoConfigureMockMvc
public class MovieApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testCorsConfiguration() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
						.options("/")
						.header("Origin", "http://example.com")
						.header("Access-Control-Request-Method", "GET")
						.header("Access-Control-Request-Headers", "X-Requested-With")
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.header().string("Access-Control-Allow-Origin", "*"))
				.andExpect(MockMvcResultMatchers.header().string("Access-Control-Allow-Headers", "X-Requested-With"))
				.andExpect(MockMvcResultMatchers.header().string("Access-Control-Max-Age", "3600"));
	}

	@Test
	public void contextLoads() {
		// This test ensures that the application context loads without errors
	}
}
