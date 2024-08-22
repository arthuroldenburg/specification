package com.example.aula.controllers;

import com.example.aula.models.PostModel;
import com.example.aula.services.PostService;
import jakarta.persistence.criteria.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostModel> getPosts(
            @RequestParam(value = "views", required = false) Integer views,
            @RequestParam(value = "views_gt", required = false) Integer views_gt,
            @RequestParam(value = "views_gte", required = false) Integer views_gte,
            @RequestParam(value = "views_lt", required = false) Integer views_lt,
            @RequestParam(value = "views_lte", required = false) Integer views_lte,
            @RequestParam(value = "views_ne", required = false) Integer views_ne,
            @RequestParam(value = "views_start", required = false) Integer start,
            @RequestParam(value = "views_end", required = false) Integer end
    ){
        Specification<PostModel> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (views != null)predicates.add(criteriaBuilder.equal(root.get("views"), views));
            if (views_gt !=null)predicates.add(criteriaBuilder.greaterThan(root.get("views"), views_gt));
            if (views_gte !=null)predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("views"), views_gte));
            if (views_lt !=null)predicates.add(criteriaBuilder.lessThan(root.get("views"), views_lt));
            if (views_lte !=null)predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("views"), views_lte));
            if (views_ne !=null)predicates.add(criteriaBuilder.notEqual(root.get("views"), views_ne));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        if (end!=null) {
            return postService.getPosts(spec, start, end);
        } else {
            return postService.getPosts(spec);
        }
    }

}
