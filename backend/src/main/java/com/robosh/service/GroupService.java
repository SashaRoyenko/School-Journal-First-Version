package com.robosh.service;

import com.robosh.data.dto.GroupDto;
import com.robosh.data.entity.Group;
import com.robosh.data.mapping.GroupMapper;
import com.robosh.data.repository.GroupRepository;
import com.robosh.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    private GroupRepository groupRepository;
    private GroupMapper groupMapper = GroupMapper.INSTANCE;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupDto> findAll() {
        return groupMapper.groupsToDto(groupRepository.findAll());
    }

    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    public GroupDto save(GroupDto groupDto) {
        return groupMapper.groupToDto(groupRepository.save(groupMapper.dtoToGroup(groupDto)));
    }

    public ResponseEntity delete(Long id) {
        groupRepository.delete(groupMapper.dtoToGroup(findById(id)));
        return ResponseEntity.ok().build();
    }

    public ResponseEntity delete(String code) {
        groupRepository.delete(groupMapper.dtoToGroup(findByCodeGroup(code)));
        return ResponseEntity.ok().build();
    }

    public GroupDto findById(Long id) {
        return groupMapper.groupToDto(groupRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Group", "id", id)
        ));
    }

    public GroupDto findByCodeGroup(String code) {
        return groupMapper.groupToDto(groupRepository.findByGroupCode(code).orElseThrow(
                () -> new ResourceNotFoundException("Group", "code", code)
        ));
    }

    public List<GroupDto> findGroupByTeacherId(Long id) {
        return groupMapper.groupsToDto(groupRepository.findGroupByTeacherId(id));
    }
}
