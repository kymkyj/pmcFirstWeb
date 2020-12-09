package com.bootproj.pmcweb.Service;

import com.bootproj.pmcweb.Domain.Attachment;
import com.bootproj.pmcweb.Common.Exception.FileDeleteException;
import com.bootproj.pmcweb.Common.Exception.FileSaveException;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface AttachmentService {
    public Optional<Attachment> getAttachment(Long attachmentId);
    public Optional<Attachment> getProfile(String email);
    public Attachment uploadProfile(MultipartFile file, String email) throws FileSaveException, NoSuchElementException;
    public void deleteProfile(String email) throws FileDeleteException, IllegalArgumentException;
    public void updateAttachment(Long attachmentId, String path, String name) throws IllegalArgumentException;
    public List<Attachment> getStudyAttachments(Long studyId);
    public Optional<Attachment> getStudyMainImage(Long studyId);
    public void uploadStudyMainImage(MultipartFile file, Long studyId) throws FileSaveException;
    public void deleteStudyMainImage(Long studyId) throws FileDeleteException, IllegalArgumentException;

}
