import com.harsh.springmvcboot.Model.Aliens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlienRepo extends JpaRepository<Aliens, Integer>
{

//    List<Aliens> findByAnameOrderByAidDesc(String aname); //Query DSL

    @Query("from Aliens where aname = :name")
    List<Aliens> find(@Param("name") String aname);


}
