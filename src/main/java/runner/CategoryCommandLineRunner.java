package runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

public class CategoryCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Category scifi = new Category("Sci-Fi");
        Category comic = new Category("Comic");

        categoryRepository.save(scifi);
        categoryRepository.save(comic);
        
        System.out.println("Categories inserted successfully!");
    }

}
