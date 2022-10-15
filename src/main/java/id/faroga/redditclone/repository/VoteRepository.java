package id.faroga.redditclone.repository;

import id.faroga.redditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Long> {
}
