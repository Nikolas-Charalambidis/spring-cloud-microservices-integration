package cz.vse.chan01.mi.api.document;


import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cz.vse.chan01.swagger.contract.model.Contract;
import cz.vse.chan01.swagger.document.api.DocumentApi;
import cz.vse.chan01.swagger.document.model.Document;
import cz.vse.chan01.swagger.document.model.VersionedDocument;

@RestController("/")
public class DocumentController implements DocumentApi {

	private final DocumentService documentService;

	private final VersionedDocumentService versionedDocumentService;

	public DocumentController(
		final DocumentService documentService,
		final VersionedDocumentService versionedDocumentService
	) {
		this.documentService = documentService;
		this.versionedDocumentService = versionedDocumentService;
	}

	@PostMapping("foo")
	public ResponseEntity<String> d(@RequestBody Contract c) {
		return ResponseEntity.ok(this.documentService.document(c));
	}

	@Override
	public ResponseEntity<List<Document>> documents() {
		return ResponseEntity.ok(documentService.documents());
	}

	@Override
	public ResponseEntity<Document> documentById(final String documentId) {
		return ResponseEntity.ok(documentService.documentById(documentId));
	}

	@Override
	public ResponseEntity<Void> postDocument(final Document document) {
		String id = this.documentService.document(document);
		final URI location = ServletUriComponentsBuilder
			.fromCurrentRequest().path("/{id}")
			.buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public ResponseEntity<VersionedDocument> versionedDocumentById(
		final String documentId, final String versionedDocumentId)
	{
		return ResponseEntity.ok(this.versionedDocumentService.versionedDocumentById(documentId, versionedDocumentId));
	}

	@Override
	public ResponseEntity<Void> postDocumentVersion(String documentId, final VersionedDocument versionedDocument) {
		this.versionedDocumentService.versionedDocument(documentId, versionedDocument);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
