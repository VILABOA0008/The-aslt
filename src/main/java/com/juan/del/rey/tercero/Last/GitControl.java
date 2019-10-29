package com.juan.del.rey.tercero.Last;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.jgit.api.AddCommand;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PushCommand;
import org.eclipse.jgit.api.errors.ConcurrentRefUpdateException;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.JGitInternalException;
import org.eclipse.jgit.api.errors.NoFilepatternException;
import org.eclipse.jgit.api.errors.NoHeadException;
import org.eclipse.jgit.api.errors.NoMessageException;
import org.eclipse.jgit.api.errors.WrongRepositoryStateException;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.PushResult;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;

public class GitControl {

  private String localPath, remotePath;
  private Repository localRepo;
  private Git git;
  private CredentialsProvider cp;
  private String name = "inutilss";
  private String password = "contraseñaparainutilss";

  public GitControl(String localPath, String remotePath) throws IOException {
    this.localPath = "C:\\Users\\pabcos\\Documents\\The alst\\The-aslt";
    this.remotePath = "https://github.com/VILABOA0008/The-aslt.git";
    this.localRepo = new FileRepository(localPath + "/.git");
    cp = new UsernamePasswordCredentialsProvider(this.name, this.password);
    git = new Git(localRepo);
    System.err.println("bien");
    System.err.println(cp);
  }

  public void addToRepo() throws IOException, NoFilepatternException, GitAPIException {
    AddCommand add = git.add();
    add.addFilepattern(".").call();
  }

  public void commitToRepo(String message)
      throws IOException, NoHeadException, NoMessageException, ConcurrentRefUpdateException,
          JGitInternalException, WrongRepositoryStateException, GitAPIException {
    git.commit().setMessage(message).call();
  }

  public void pushToRepo()
      throws IOException, JGitInternalException, InvalidRemoteException, GitAPIException {
    PushCommand pc = git.push();
    pc.setCredentialsProvider(cp).setForce(true).setPushAll();
    try {
      Iterator<PushResult> it = pc.call().iterator();
      if (it.hasNext()) {
        System.out.println(it.next().toString());
      }
    } catch (InvalidRemoteException e) {
      e.printStackTrace();
    }
  }
}
