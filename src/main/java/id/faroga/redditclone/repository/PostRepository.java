package id.faroga.redditclone.repository;

import id.faroga.redditclone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
