package com.robosh.service;

import com.robosh.data.entity.Rebuke;
import com.robosh.data.repository.RebukeRepository;
import com.robosh.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RebukeService {
    private RebukeRepository rebukeRepository;

    public Rebuke save(Rebuke rebuke) {
        return rebukeRepository.save(rebuke);
    }

    public List<Rebuke> findByStudentId(Long id) {
        return rebukeRepository.findByStudentId(id);
    }

    public Rebuke findById(Long id) {
        return rebukeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Rebuke", "id", id)
        );
    }

    public ResponseEntity deleteById(Long id) {
        rebukeRepository.delete(findById(id));
        return ResponseEntity.ok().build();
    }
}
